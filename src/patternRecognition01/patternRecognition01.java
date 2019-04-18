package enshu02;
import java.io.*;

public class kadai02 {

	public static void main(String[] args) {
		try {
			////ファイル読み込み
		      File f = new File("E:\\temp/iris.txt");
		      BufferedReader br = new BufferedReader(new FileReader(f));
		 
		      String line = br.readLine();
		      double samples[][] = new double[150][5];
		      for (int i = 0; i < 150; i++) {
		    	  String str[] = new String[5];
		    	  str = line.split(" ");
		    	  for (int j = 0; j < 5; j++) {
		    		  samples[i][j] =  Double.parseDouble(str[j]);
		    		  //System.out.println(samples[i][j]);
		    	  }
		    	  line = br.readLine();
		      }
		      
		      /////平均ベクトルの算出
		      
		      for (int k = 0; k < 3; k++) {
		    	  
//		    	  if (k == 0) {
//		    		  System.out.println("Setosa:");
//		    	  } else if (k == 1) {
//		    		  System.out.println("Versicolor:");
//		    	  } else if (k == 2) {
//		    		  System.out.println("Verginica:");
//		    	  } 
		    	  
		    	  double totalGakuLength = 0;
			      double totalGakuWidth = 0;
			      double totalKabenLength = 0;
			      double totalKabenWidth = 0;
		    	  for (int i = 0 + 50*k; i < 50 + 50*k; i++) {
		    		  for(int j = 0; j < 5; j++) {
		    			  if (j == 0) {
		    				  totalGakuLength += samples[i][j];
		    			  } else if (j == 1) {
		    				  totalGakuWidth += samples[i][j];
		    			  } else if (j == 2) {
		    				  totalKabenLength += samples[i][j];
		    			  } else if (j ==3) {
		    				  totalKabenWidth += samples[i][j];
		    			  }
		    		  }
		    	  }
//		    	  System.out.println("がく片の長さの平均ベクトル：" + totalGakuLength / 50);
//		    	  System.out.println("がく片の幅の平均ベクトル：" + totalGakuWidth / 50);
//		    	  System.out.println("花弁の長さの平均ベクトル：" + totalKabenLength / 50);
//		    	  System.out.println("花弁の幅の平均ベクトル：" + totalKabenWidth / 50);
		    	  
		    	  //標準偏差ベクトルの算出
		    	  double SDGakuLength = 0;
			      double SDGakuWidth = 0;
			      double SDKabenLength = 0;
			      double SDKabenWidth = 0;
		    	  for (int i = 0 + 50*k; i < 50 + 50*k; i++) {
		    		  for(int j = 0; j < 5; j++) {
		    			  if (j == 0) {
		    				  SDGakuLength += Math.pow(samples[i][j] - totalGakuLength / 50, 2);
		    			  } else if (j == 1) {
		    				  SDGakuWidth += Math.pow(samples[i][j] - totalGakuWidth / 50, 2);
		    			  } else if (j == 2) {
		    				  SDKabenLength += Math.pow(samples[i][j] - totalKabenLength / 50, 2);
		    			  } else if (j ==3) {
		    				  SDKabenWidth += Math.pow(samples[i][j] - totalKabenWidth / 50, 2);
		    			  }
		    		  }
		    	  }
		    	  
//		    	  System.out.println("がく片の長さの標準偏差ベクトル：" + Math.sqrt(SDGakuLength / 50));
//		    	  System.out.println("がく片の幅の標準偏差ベクトル：" + Math.sqrt(SDGakuWidth / 50));
//		    	  System.out.println("花弁の長さの標準偏差ベクトル：" + Math.sqrt(SDKabenLength / 50));
//		    	  System.out.println("花弁の幅の標準偏差ベクトル：" + Math.sqrt(SDKabenWidth / 50));
//		    	  System.out.println("");
		    	  
		      }
		      
		      ////線形識別機関数型分類器の実装
		      double id;
		      double c;
		      int t = 0;
		      double p = 0.01;
		      double w[] = {0.33, 0.23, -0.38, -0.05, 0.47};
		      double cnt = 0;
		      for (int i = 0; i < 100; i++) {
		    	      t++;
		    	  	  id = w[0] + w[1] * samples[i][0] + w[2] * samples[i][1] + w[3] * samples[i][2] + w[4] * samples[i][3];
		    		  if (id > 0) {
		    			  c = 1.0;
		    		  } else {
		    			  c = 2.0;
		    		  }
		    		  
		    		  for (int k =0; k < 15; k++) {
		    			  if (c == 1.0 && c != samples[i][4]) {
		    				  for(int j = 0; j < 5; j++) {
		    					  w[j] += p * samples[i][j];
		    				  }
		    			  } else if (c == 2.0 && c != samples[i][4]) {
		    				  for(int j = 0; j < 5; j++) {
		    					  w[j] -= p * samples[i][j];
		    				  }
		    			  }
		    		  }
		    		  if (c == samples[i][4]) {
		    			  cnt++;
		    		  } 
		      }
		      
		      System.out.println("分類精度は" + cnt + "%");
		      for(int i = 0; i < 5; i++) {
		    	  System.out.println(w[i]);
		      }
		      
		      

		      //while (line != null) {
		        //System.out.println(line);
		        //line = br.readLine();
		     // }
		      br.close();
		    } catch (IOException e) {
		      System.out.println(e);
		    }
	}

}
