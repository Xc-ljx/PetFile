
package com.xc.candidate.mapper;

import com.xc.candidate.model.Candidate;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject:dream_house
 * @BelongsPackage:com.example.dream_house.mapper
 * @Author:Uestc_Xiye
 * @CreateTime:2023-12-17 16:36:57
 */
/**
 * @description candidate
 * @author BEJSON
 * @date 2025-02-21
 */
@Mapper
@Repository
public interface CandidateMapper {

    /**
     * 新增
     *
     * @author BEJSON
     * @date 2025/02/21
     **/
    int insert(Candidate candidate);

    /**
     * 刪除
     *
     * @author BEJSON
     * @date 2025/02/21
     **/
    int delete(int id);

    /**
     * 更新
     *
     * @author BEJSON
     * @date 2025/02/21
     **/
    int update(Candidate candidate);

    /**
     * 查询 根据主键 id 查询
     *
     * @author BEJSON
     * @date 2025/02/21
     **/
    Candidate load(int id);

    /**
     * 查询 分页查询
     *
     * @author BEJSON
     * @date 2025/02/21
     **/
    List<Candidate> pageList(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询 分页查询 count
     *
     * @author BEJSON
     * @date 2025/02/21
     **/
    int pageListCount(int offset, int pagesize);

}
