package com.xc.busService;

import java.io.InputStream;

public interface BusDownloadFileService {

    InputStream getInputStreamByUrl(String url);

}
