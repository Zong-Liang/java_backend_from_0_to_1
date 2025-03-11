package com.tlias.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class AliyunOSSUtil {
    @Autowired
    private AliyunOSSProperties aliyunOSSProperties;


    public String uploadFileToOSS(InputStream fileStream, String objectName) throws com.aliyuncs.exceptions.ClientException {
        String endpoint = aliyunOSSProperties.getEndpoint();
        String bucketName = aliyunOSSProperties.getBucketName();
        String region = aliyunOSSProperties.getRegion();
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        //获取当前系统日期的字符串,格式为 yyyy/MM
        String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
        //生成一个新的不重复的文件名
        String newFileName = UUID.randomUUID() + objectName.substring(objectName.lastIndexOf("."));
        String newoObjectName = dir + "/" + newFileName;


        // 创建OSSClient实例
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();

        try {
            // 创建PutObjectRequest对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, newoObjectName, fileStream);
            // 上传文件
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.err.println("Caught an OSSException, which means your request made it to OSS, but was rejected with an error response for some reason.");
            System.err.println("Error Message:" + oe.getErrorMessage());
            System.err.println("Error Code:" + oe.getErrorCode());
            System.err.println("Request ID:" + oe.getRequestId());
            System.err.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.err.println("Caught a ClientException, which means the client encountered a serious internal problem while trying to communicate with OSS, such as not being able to access the network.");
            System.err.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + newoObjectName;
    }
}
