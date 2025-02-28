
package com.xc.candidate.service.impl;

import com.xc.candidate.constants.ReturnT;
import com.xc.candidate.mapper.CandidateMapper;
import com.xc.candidate.model.Candidate;
import com.xc.candidate.service.CandidateService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * @description candidate
 * @author l00845811
 * @date 2025-02-21
 */
@Service
public class CandidateServiceImpl implements CandidateService {

    @Resource
    private CandidateMapper candidateMapper;

    @Override
    public Object insert(Candidate candidate) {

        // valid
        if (candidate == null) {
            return ReturnT.error("必要参数缺失");
        }

        candidateMapper.insert(candidate);
        return ReturnT.success();
    }

    @Override
    public Object delete(int id) {
        int ret = candidateMapper.delete(id);
        return ret > 0 ? ReturnT.success() : ReturnT.error();
    }

    @Override
    public Object update(Candidate candidate) {
        int ret = candidateMapper.update(candidate);
        return ret > 0 ? ReturnT.success() : ReturnT.error();
    }

    @Override
    public Candidate load(int id) {
        return candidateMapper.load(id);
    }

    @Override
    public Map<String, Object> pageList(int offset, int pageSize) {

        List<Candidate> pageList = candidateMapper.pageList(offset, pageSize);
        int totalCount = candidateMapper.pageListCount(offset, pageSize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

}