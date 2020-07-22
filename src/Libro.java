import com.google.gson.JsonArray;

/**
 * 
 */

/**
 * @author Juan Muñoz
 *
 */
public class Libro {
	String passage;
	//List<String> chapters;
	JsonArray chapters;
	
	public String getPassage() {
		return passage;
	}
	public void setPassage(String passage) {
		this.passage = passage;
	}
	public JsonArray getChapters() {
		return chapters;
	}
	public void setChapters(JsonArray chapters) {
		this.chapters = chapters;
	}

}
