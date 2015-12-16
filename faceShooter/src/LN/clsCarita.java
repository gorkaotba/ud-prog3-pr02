package LN;

import java.awt.Image;


public class clsCarita {

		 private Image img;
		 private int x;			// the X coordinate
		 private int y;			// the Y coordinat
		 private int width;
		 private int height;
		 private int colorIndex;
		 private boolean destroy ;
		 private boolean markedCheck=false;
		 private int noOfShiftedRows=0;
		
//		Speed speed;

		public clsCarita() {
			// TODO Auto-generated constructor stub
			img=null;
			x=0;
			y=0;
			width=0;
			height=0;
			destroy=true;
			boolean markedCheck=false;
			int noOfShiftedRows=0;
		}
		
		public clsCarita(int x, int y, int witdth, int height) {
			super();
			
			this.x = x;
			this.y = y;
			this.width= witdth;
			this.height= height;
			colorIndex=0;
			destroy = false;
//			this.speed = new Speed();
		}
		public clsCarita( int x, int y,int colInd,boolean check) {
			// TODO Auto-generated constructor stub
//			GameScreen.width = bitmap.getWidth();
//			GameScreen.height=bitmap.getHeight();
			this.x = x;
			this.y = y;
			colorIndex=colInd;
			destroy = false;
			markedCheck=check;
			
		}


		public void draw(Canvas canvas) {
			canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
		}

		public Image getImg() {
			return img;
		}

		public void setImg(Image img) {
			this.img = img;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getColorIndex() {
			return colorIndex;
		}

		public void setColorIndex(int colorIndex) {
			this.colorIndex = colorIndex;
		}

		public boolean isDestroy() {
			return destroy;
		}

		public void setDestroy(boolean destroy) {
			this.destroy = destroy;
		}

		public boolean isMarkedCheck() {
			return markedCheck;
		}

		public void setMarkedCheck(boolean markedCheck) {
			this.markedCheck = markedCheck;
		}

		public int getNoOfShiftedRows() {
			return noOfShiftedRows;
		}

		public void setNoOfShiftedRows(int noOfShiftedRows) {
			this.noOfShiftedRows = noOfShiftedRows;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
		
	
	
}
