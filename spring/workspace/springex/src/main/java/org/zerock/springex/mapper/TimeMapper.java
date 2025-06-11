package org.zerock.springex.mapper;

import org.apache.ibatis.annotations.Select;
//mybatis에서 사용하는 SQL을 설정하는 인터페이스
public interface TimeMapper {
    @Select("SELECT now()")
    String getTime();
    // @Insert()
    // @Delete()
    // @Update()

}
