package vo;

public class Announcement {
	//기본생성자
	public Announcement() {}
	// 필드생성
	private int announcementNo;
	private String announcementTitle;
	private String announcementContent;
	private String createDate;
	
	// toString() : 필드값을 문자열로 출력
		@Override
		public String toString() {
			return "Announcement [announcementNo=" + announcementNo + ", announcementTitle=" + announcementTitle
					+ ", announcementContent=" + announcementContent + ", createDate=" + createDate + "]";
		}
		
	public int getAnnouncementNo() {
		return announcementNo;
	}
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	public String getAnnouncementContent() {
		return announcementContent;
	}
	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setAnnouncementNo(int announcementNo) {
		this.announcementNo = announcementNo;
	}
	
	
	
	
	
}
