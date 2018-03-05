package com.app.OldpartyLecture.model;

public class BookChapter {
		private int book_table_id;
		//图书id
		private int book_id;
		//章节页数
		private int chapter_id;
		//字数
		private int word_count;
//		//是否可读
//		private boolean free;
		//章节题目
		private String chapter_title;
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
		public int getBook_table_id() {
			return book_table_id;
		}
		public void setBook_table_id(int book_table_id) {
			this.book_table_id = book_table_id;
		}
		
}
