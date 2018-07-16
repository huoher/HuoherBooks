package top.qiuchi.huoher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.qiuchi.huoher.entity.Writer;

import java.util.List;

@Repository
@Mapper
public interface WriterMapper {

    @Select("select * from writer")
    public List<Writer> queryWriter();

    @Insert("insert into writer(writername) values(#{writername})")
    public void addWriter(Writer writer);

    @Delete("delete from writer where id = #{id}")
    public void deleteWriter(Writer writer);
}
