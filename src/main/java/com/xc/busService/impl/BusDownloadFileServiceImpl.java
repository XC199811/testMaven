package com.xc.busService.impl;

import com.xc.busService.BusDownloadFileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author cuilb
 * @Data 2022 06 28 15:35
 * @Description
 */
@Service
public class BusDownloadFileServiceImpl implements BusDownloadFileService {

    public InputStream getInputStreamByUrl(String strUrl){
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(),output);
            return  new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {

        }finally {
            try{
                if (conn != null) {
                    conn.disconnect();
                }
            }catch (Exception e){

            }
        }
        return null;
    }

}
