package com.course.business.controller.admin;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.ChapterService;
import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);
    public static final String BUSINESS_NAME = "大章";

    @Resource
    private ChapterService chapterService;


    /**
     * 查询business列表
     *
     * @param pageDto
     * @return
     */
    @RequestMapping("/list")
    public ResponseDto chapter(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        chapterService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 新增business
     *
     * @param chapterDto
     * @return
     */
    @RequestMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {

        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    /**
     * 删除business
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable("id") String id) {
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        responseDto.setContent(id);
        return responseDto;
    }



    /**
     * 根据id修改business
     *
     * @param chapterDto
     * @return
     */
    @RequestMapping(value = "/edit")
    public ResponseDto edit(@RequestBody ChapterDto chapterDto) {
        // 保存校验
        ResponseDto responseDto = new ResponseDto();
        chapterService.edit(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }


}
