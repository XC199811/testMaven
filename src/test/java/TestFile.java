import com.xc.model.entity.LocalTest;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author cuilb
 * @Data 2022 06 28 15:13
 * @Description
 */
public class TestFile {

    public static void main(String[] args) {
        String fileName = "shoope.exe";
        String substring = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(substring);

    }

    /**
     * 根据地址获得数据的输入流
     * @param strUrl 网络连接地址
     * @return url的输入流
     */
    public static InputStream getInputStreamByUrl(String strUrl){
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

    public static void testException() {
        try {
            throw new RuntimeException("不想玩了！！！");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
