package com.sandrew.boot.service.common;


import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 *  公共Service
 * Created by summer on 2018/2/15.
 */
public interface CommonService
{
    /**
     *  文件上传
     * @param relativePath  相对路径
     * @param file          上传文件
     * @return
     * @throws ServiceException
     */
    JsonResult fileUploadLocal(String relativePath, MultipartFile file) throws ServiceException;

    /**
     *  显示本地图片
     * @param relativePath  相对路径
     * @return
     * @throws ServiceException
     */
    byte[] downloadFile(String relativePath) throws ServiceException;

}
