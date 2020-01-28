package com.sandrew.boot.controller.common;

import com.sandrew.boot.core.captcha.RandCodeImageUtils;
import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.exception.ActionException;
import com.sandrew.boot.core.exception.JsonException;
import com.sandrew.boot.service.common.CommonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Log4j2
@Controller
@RequestMapping(value = "/generate")
public class GenerateImageController
{

    @Resource
    CommonService commonService;

    private final static String AVATAR_PATH = "/avatar";

    /**
     * 生成验证码图片io流
     */
    @RequestMapping(value = "image", method = RequestMethod.GET)
    public void generateImage(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException
    {
        RandCodeImageUtils.generateImage(response, request);
    }

    @RequestMapping("uploadImg")
    public @ResponseBody JsonResult uploadImage(String filePath, MultipartFile file) throws JsonException
    {
        try
        {
            return commonService.fileUploadLocal(AVATAR_PATH, file);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new JsonException("图片上传失败", e);
        }

    }

    /**
     *  查看图片
     * @param filePath  相对路径
     * @param response
     * @throws ActionException
     */
    @RequestMapping("loadImage")
    public void loadImage(String filePath, HttpServletResponse response) throws ActionException
    {
        log.debug("loadImage------------------");
        OutputStream outputStream = null;
        try
        {
            // 文件服务器下载附件
            byte[] bytes = commonService.downloadFile(filePath);
            outputStream = response.getOutputStream();
            response.setContentType("application/octet-stream;charset=UTF-8");
            FileCopyUtils.copy(bytes, outputStream);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ActionException("查看图片失败", e);
        }
    }
}
