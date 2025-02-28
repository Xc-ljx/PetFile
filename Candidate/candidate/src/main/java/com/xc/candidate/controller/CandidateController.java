
package com.xc.candidate.controller;

import com.xc.candidate.model.Candidate;
import com.xc.candidate.service.CandidateService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import javax.annotation.Resource;

/**
 * 候选人管理
 *
 * @author l00845811
 * @since 2025-02-21
 */
@RestController
@RequestMapping(value = "/candidate")
@CrossOrigin(origins = "*")
public class CandidateController {

    @Resource
    private CandidateService candidateService;

    /**
     * 新增
     *
     * @author xc
     * @date 2025/02/21
     **/
    @RequestMapping("/insert")
    public Object insert(@RequestBody Candidate candidate) {
        return candidateService.insert(candidate);
    }

    /**
     * 刪除
     *
     * @author xc
     * @date 2025/02/21
     **/
    @RequestMapping("/delete")
    public Object delete(int id) {
        return candidateService.delete(id);
    }

    /**
     * 更新
     *
     * @author xc
     * @date 2025/02/21
     **/
    @RequestMapping("/update")
    public Object update(Candidate candidate) {
        return candidateService.update(candidate);
    }

    /**
     * 查询 根据主键 id 查询
     *
     * @author xc
     * @date 2025/02/21
     **/
    @RequestMapping("/load")
    public Object load(int id) {
        return candidateService.load(id);
    }

    /**
     * 查询 分页查询
     *
     * @author xc
     * @date 2025/02/21
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
        @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return candidateService.pageList(offset, pageSize);
    }
}
