
public class Movie3Model {

	private String movieName;
	private String ageRating;
	private String description;
	private String experiences;
	private String showTime;
	
	public Movie3Model(){
		
		this.movieName = new String();
		this.ageRating = new String();
		this.description = new String();
		this.experiences = new String();
		this.showTime = new String();
			
		}
		
	public String getMovieName() {
		return this.movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getAgeRating() {
		return this.ageRating;
	}
	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getExperiences() {
		return this.experiences;
	}
	public void setExperiences(String experiences) {
		this.experiences = experiences;
	}
	
	public String getShowTime() {
		return this.showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
}
