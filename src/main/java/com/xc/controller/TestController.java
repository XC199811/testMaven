package com.xc.controller;

import com.xc.busService.BusDownloadFileService;
import com.xc.busService.BusLocalTestService;
import com.xc.model.entity.LocalTest;
import com.xc.model.param.LocalTestSaveParam;
import com.xc.model.response.ResponseDTO;
import com.xc.service.LocalhostTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author cuilb
 * @Data 2022 06 28 10:44
 * @Description
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Api(value = "testController", tags = "测试controller")
public class TestController {

    private final LocalhostTestService localhostTestService;

    private final BusLocalTestService busLocalTestService;

    private final BusDownloadFileService busDownloadFileService;

    private static final String[] DOWN_LOAD = {"inline", "attachment"};

    @ApiOperation(value = "/test", tags = "测试通过")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello word!!!";
    }

    @ApiOperation("获取全部")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<LocalTest> getAll() {
        return localhostTestService.list();
    }

    @ApiOperation("保存单个")
    @PostMapping("/save/one")
    public ResponseDTO<?> saveOne(@RequestBody @Valid LocalTestSaveParam localTestSaveParam) {
       return ResponseDTO.ok(busLocalTestService.saveOne(localTestSaveParam));
    }

    @GetMapping("/download")
    @ApiOperation("下载文件")
    public ResponseEntity<byte[]> downloadFileByUrl() throws IOException {
        InputStream inputStream = busDownloadFileService.getInputStreamByUrl("https://image.whatsappscrm.com/scriptUploadFile/user_portrait.scrmbin");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, byteArrayOutputStream);
        inputStream.close();
        HttpHeaders headers = new HttpHeaders();
        //设置下载协议头。下面fileName的两次转换主要是为了保证中文文件名
        String fileName = new String("user_portrait.scrmbin".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, DOWN_LOAD[1] + ";filename=" + new String(fileName.getBytes(), StandardCharsets.UTF_8));
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.ALL_VALUE);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
        byteArrayOutputStream.close();
        return responseEntity;
    }



}
