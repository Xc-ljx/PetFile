
package com.xc.candidate.utils;

import com.xc.candidate.model.CandidateStatus;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateStatusTypeHandler extends BaseTypeHandler<CandidateStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CandidateStatus parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter.getDescription());
    }

    @Override
    public CandidateStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String description = rs.getString(columnName);
        return CandidateStatus.valueOfCode(description);
    }

    @Override
    public CandidateStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String description = rs.getString(columnIndex);
        return CandidateStatus.valueOfCode(description);
    }

    @Override
    public CandidateStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String description = cs.getString(columnIndex);
        return CandidateStatus.valueOfCode(description);
    }
}