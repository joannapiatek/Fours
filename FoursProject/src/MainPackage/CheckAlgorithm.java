package MainPackage;

public class CheckAlgorithm {
	
	private static Player player;
	private static boolean playerWon;

	
	public static boolean checkAll(Player player)
	{
		checkHorizontal();
		if(playerWon)
		{
			return playerWon;
		}
		
		checkVertical();
		if(playerWon)
		{
			return playerWon;
		}
		
		checkDiagonal();
		return playerWon;
	}
	
	
	public static void checkHorizontal()
	{
		for(int i=0; i<6; i++)
		{
			for(int j=0; j<4; j++)
			{
				if(player.playerTab[i][j] && player.playerTab[i][j+1] && player.playerTab[i][j+2] && player.playerTab[i][j+3])
					playerWon = true;
			}
		}
	}
	
	public static void checkVertical()
	{
		for (int j=0; j<7; j++)
		{
			for (int i=0; i<3; i++)
			{
				if(player.playerTab[i][j] && player.playerTab[i+1][j] && player.playerTab[i+2][j] && player.playerTab[i+3][j])
					playerWon = true;
			}
		}
	}
	
	public static void checkDiagonal()
	{
		slash();			//			/
		backslash(); 		//			\
	}
	
	public static void slash()
	{
		for (int i=0; i<3; i++)
		{
			for(int j=0; j<4; j++)
			{
				if(player.playerTab[i][j] && player.playerTab[i+1][j+1] && player.playerTab[i+2][j+2] && player.playerTab[i+3][j+3])
					playerWon = true;
			}
		}
	}
	
	public static void backslash()
	{
		for (int i=0; i<3; i++)
		{
			for(int j=3; j<7; j++)
			{
				if(player.playerTab[i][j] && player.playerTab[i+1][j-1] && player.playerTab[i+2][j-2] && player.playerTab[i+3][j-3])
					playerWon = true;
			}
		}
	}
}
