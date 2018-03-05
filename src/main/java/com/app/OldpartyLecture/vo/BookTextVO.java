package com.app.OldpartyLecture.vo;

public class BookTextVO {
		//章节id
		private int book_id;
		//用户id
		private int user_id;
		//章节页数
		private int chapter_id;
		//章节内容
		private String context;
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public int getChapter_id() {
			return chapter_id;
		}
		public void setChapter_id(int chapter_id) {
			this.chapter_id = chapter_id;
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
}
