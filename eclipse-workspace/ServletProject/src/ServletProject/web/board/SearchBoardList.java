package ServletProject.web.board;

import lombok.Data;

@Data
public class SearchBoardList {
	private String searchType = "";
	private String keyWorkd = "";
	private int page = 0;
	

}
