package program.dto;

public class ProgramDTO {
    private int id;
    private String title;
    private String text;
    private String subtext;
    private String schedule;
    private String img;

    public ProgramDTO() {}

    public ProgramDTO(int id, String title, String text, String subtext, String schedule, String img) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.subtext = subtext;
        this.schedule = schedule;
        this.img = img;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getSubtext() {
        return subtext;
    }
    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }
    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
