package com.app.OldpartyLecture.model;

public class BookText {
		//章节页数
		private int chapter_id;
		//章节内容
		private String context;
		//章节id
		private int book_id;
		//用户id
		private int user_id;
		//章节标题
		private String chapter_title;
		public int getChapter_id() {
			return chapter_id;
		}
		public void setChapter_id(int chapter_id) {
			this.chapter_id = chapter_id;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getBook_id() {
			return book_id;
		}
		public void setBook_id(int book_id) {
			this.book_id = book_id;
		}
		public String getChapter_title() {
			return chapter_title;
		}
		public void setChapter_title(String chapter_title) {
			this.chapter_title = chapter_title;
		}
}
