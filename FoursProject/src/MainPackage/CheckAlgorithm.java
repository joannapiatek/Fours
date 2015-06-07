package MainPackage;

public class CheckAlgorithm {
	
	private int rows;
	private int columns;
	private boolean player1Win;
	private boolean player2Win;
	private boolean [][] player1Tab;
	private boolean [][] player2Tab;
	private Player pl1;
	private Player pl2;
		
	public CheckAlgorithm(int rows, int columns, Player player1, Player player2){
		this.rows = rows;
		this.columns = columns;
		
		Player pl1 = player1;
		Player pl2 = player2;
		
		playerTabInit();
	}
	
	public void playerTabInit()
	{
		player1Tab = new boolean [rows][columns];
		player2Tab = new boolean [rows][columns];
		
		for (int i=0; i<6; i++)
		{
			for (int j=0; j<7; j++)
			{
				player1Tab[i][j]=false;
				player2Tab[i][j]=false;
			}
		}
	}
	
	public void checkAll()
	{
		checkHorizontal();
		if(player1Win || player2Win)
		{
			playerWonAction();
		}
		
		checkVertical();
		if(player1Win || player2Win)
		{
			playerWonAction();
		}
		
		checkDiagonal();
	}
	
	
	public void checkHorizontal()
	{
		for(int i=0; i<6; i++)
		{
			for(int j=0; j<4; j++)
			{
				if(pl1.isActiveTurn()){
					if(player1Tab[i][j] && player1Tab[i][j+1] && player1Tab[i][j+2] && player1Tab[i][j+3])
						player1Win = true;
				}
				
				if(pl2.isActiveTurn()){
					if(player2Tab[i][j] && player2Tab[i][j+1] && player2Tab[i][j+2] && player2Tab[i][j+3])
						player2Win = true;
				}
				
			}
		}
	}
	
	public void checkVertical()
	{
		for (int j=0; j<7; j++)
		{
			for (int i=0; i<3; i++)
			{
				if(pl1.isActiveTurn()){
					if(player1Tab[i][j] && player1Tab[i+1][j] && player1Tab[i+2][j] && player1Tab[i+3][j])
						player1Win = true;
				}
				
				if(pl2.isActiveTurn()){
					if(player2Tab[i][j] && player2Tab[i+1][j] && player2Tab[i+2][j] && player2Tab[i+3][j])
						player2Win = true;
				}
			}
		}
	}
	
	public void checkDiagonal()
	{
		slash();			//			/
		if(player1Win || player2Win)
		{
			playerWonAction();
		}
		
		backslash(); 		//			\
		if(player1Win || player2Win)
		{
			playerWonAction();
		}
	}
	
	public void slash()
	{
		for (int i=0; i<3; i++)
		{
			for(int j=0; j<4; j++)
			{
				if(pl1.isActiveTurn()){
					if(player1Tab[i][j] && player1Tab[i+1][j+1] && player1Tab[i+2][j+2] && player1Tab[i+3][j+3])
						player1Win = true;
				}
				
				if(pl2.isActiveTurn()){
					if(player2Tab[i][j] && player2Tab[i+1][j+1] && player2Tab[i+2][j+2] && player2Tab[i+3][j+3])
						player2Win = true;
				}
			}
		}
	}
	
	public void backslash()
	{
		for (int i=0; i<3; i++)
		{
			for(int j=3; j<7; j++)
			{
				if(pl1.isActiveTurn()){
					if(player1Tab[i][j] && player1Tab[i+1][j-1] && player1Tab[i+2][j-2] && player1Tab[i+3][j-3])
						player1Win = true;
				}
				
				if(pl2.isActiveTurn()){
					if(player2Tab[i][j] && player2Tab[i+1][j-1] && player2Tab[i+2][j-2] && player2Tab[i+3][j-3])
						player2Win = true;
				}
			}
		}
	}
	
	public void playerWonAction()
	{
		// jak kto� wygra�, to dzieje si� to:
	}
	
}
