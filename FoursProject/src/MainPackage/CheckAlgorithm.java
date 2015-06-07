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
		
	public CheckAlgorithm(int rows, int columns,Player player1, Player player2){
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
		checkVertical();
		checkDiagonally();
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
	
}
