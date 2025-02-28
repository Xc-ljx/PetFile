package com.example.dream_house.mapper;

import com.example.dream_house.model.Candidate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述
 *
 * @author l00845811
 * @since 2025-02-20
 */
@Mapper
public interface CandidateMapper {
    int insert(Candidate candidate);

    int update(Candidate candidate);

    int delete(Long id);

    List<Candidate> selectByCondition(Candidate condition);
}