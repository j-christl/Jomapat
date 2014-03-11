package me.inplex.jomapat;

public class WorldGenerator {



	public static World generateWorld(int width,int height){
		World world = new World(width, height);
		Block grass = new BlockGrass();
		Block dirt = new BlockDirt();
		Block stone = new BlockStone();
		Block diamond = new BlockDiamond();
		
		dirt.load();
		grass.load();
		stone.load();
		diamond.load();

		int actualStartY = 2;

		for (int x=0;x<=width-1;x++){

			// World height

			switch (Maths.randomize(1, 4))
			{
			case 1:break;
			case 2:case 3:actualStartY=actualStartY+1;break;
			case 4:       actualStartY=actualStartY-1;break;
			}

			if (actualStartY<0){actualStartY=0;}



			for (int y=actualStartY;y<=height-1;y++){


				if (y==actualStartY ){ //Use Grass or deeper grounds
					world.setBlock(x,y,grass);
				}else{
					if (y<11){ // Use dirt or stone
						world.setBlock(x,y,dirt);	
					}else{
						if (Maths.randomize(1, 10)==5) //... or maybe diamond...
						{
							world.setBlock(x,y,diamond);
						}else{
							world.setBlock(x,y,stone);	
						}
					}
				}

			}
		}



		return world;
	}

}