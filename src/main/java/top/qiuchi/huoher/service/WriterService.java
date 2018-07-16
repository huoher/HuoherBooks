package top.qiuchi.huoher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qiuchi.huoher.entity.Writer;
import top.qiuchi.huoher.mapper.WriterMapper;

import java.util.List;

@Service
public class WriterService {

    @Autowired
    private WriterMapper writerMapper;

    public List<Writer> getAllWriter(){
        System.out.println(writerMapper.queryWriter());
        return writerMapper.queryWriter();
    }

    public void addWriter(Writer writer){
        writerMapper.addWriter(writer);
    }

    public void deleteWriter(Writer writer){
        writerMapper.deleteWriter(writer);
    }
}
