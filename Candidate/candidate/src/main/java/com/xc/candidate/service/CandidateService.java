
package com.xc.candidate.service;

import com.xc.candidate.model.Candidate;

import java.util.Map;

/**
 * @description candidate
 * @author BEJSON
 * @date 2025-02-21
 */
public interface CandidateService {

    /**
     * 新增
     */
    public Object insert(Candidate candidate);

    /**
     * 删除
     */
    public Object delete(int id);

    /**
     * 更新
     */
    public Object update(Candidate candidate);

    /**
     * 根据主键 id 查询
     */
    public Candidate load(int id);

    /**
     * 分页查询
     */
    public Map<String, Object> pageList(int offset, int pagesize);

}
