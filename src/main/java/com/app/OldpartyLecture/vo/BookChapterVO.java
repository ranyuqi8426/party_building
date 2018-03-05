package com.app.OldpartyLecture.vo;

public class BookChapterVO {
		//图书id
		private int book_id;
		//章节id
		private int chapter_id;
		//字数
		private int word_count;
//		//user_id 插入学习记录使用
		private String user_id;
		//章节题目
		private String title;
		public int getChapter_id() {
			return chapter_id;
		}
		public void setChapter_id(int chapter_id) {
			this.chapter_id = chapter_id;
		}
		public int getWord_count() {
			return word_count;
		}
		public void setWord_count(int word_count) {
			this.word_count = word_count;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getBook_id() {
			return book_id;
		}
		public void setBook_id(int book_id) {
			this.book_id = book_id;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
}
