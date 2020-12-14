package com.project.board.dto;

import com.project.board.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String writer;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private LocalDate rDate;
    @NotEmpty
    private LocalDate mDate;

}
