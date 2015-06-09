package MainPackage;

public class CheckAlgorithm {
	
	private static boolean playerWon;

	
	public static boolean checkAll(Player player)
	{
		checkHorizontal(player);
		if(playerWon)
		{
			return playerWon;
		}
		
		checkVertical(player);
		if(playerWon)
		{
			return playerWon;
		}
		
		checkDiagonal(player);
		return playerWon;
	}
	
	
	public static void checkHorizontal(Player player)
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
	
	public static void checkVertical(Player player)
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
	
	public static void checkDiagonal(Player player)
	{
		slash(player);			//			/
		backslash(player); 		//			\
	}
	
	public static void slash(Player player)
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
	
	public static void backslash(Player player)
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
