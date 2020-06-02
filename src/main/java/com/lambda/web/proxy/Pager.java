package com.lambda.web.proxy;

import com.lambda.web.mappers.MovieMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount, rowStart, rowEnd,
                pageCount, pageSize, pageStart, pageEnd, pageNow,
                blockCount, blockSize, blockPrev, blockNext, blockNow;
    private boolean existPrev, existNext;
    private String searchWord;
    public void paging(){
        rowCount = movieMapper.count(); //50
        rowStart = pageNow * pageSize; // 0
        rowEnd = (pageNow != pageCount -1 )? rowStart + (pageSize-1): rowCount-1; // 4
        pageCount = (rowCount%pageSize!=0)? rowCount/pageSize+1: rowCount/pageSize ; // 10
        // pageSize = 5; - 외부에서 set
        pageStart= blockNow * blockSize ; //2
        pageEnd = (blockNow!=(blockCount-1))? pageStart + (blockSize - 1) : pageCount-1; // 4
        // pageNow = 1; - 외부에서 set
        blockCount = (pageCount%blockSize!=0)?pageCount / blockSize+1: pageCount / blockSize ; // 2
        // blockSize = 5; - 외부에서 set
        blockPrev = pageStart - blockSize; // 마이너스라는 개념이 없어서 0됨
        blockNext = pageStart + blockSize; // 5
        blockNow = pageNow / blockSize; // 0
        System.out.println("blockNow :: "+blockNow);
        existPrev = blockNow != 0;
        System.out.println("existPrev :: "+existPrev);
        existNext = (blockNow + 1) != blockCount;
        System.out.println("existNext :: "+existNext);
    }

}


