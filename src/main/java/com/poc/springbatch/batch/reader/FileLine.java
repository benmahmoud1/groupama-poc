package com.poc.springbatch.batch.reader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileLine {
    private String line;
    private String fileType;
    private int fileNumber;
    private int lineNumber;

}
