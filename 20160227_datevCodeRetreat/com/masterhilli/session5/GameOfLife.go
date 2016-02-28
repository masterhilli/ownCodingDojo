package GameOfLife

type Cell struct {
	isAlive         bool
	countNeighbours int
}

func (this *Cell) SetIsAlive(isAlive bool) {
	this.isAlive = isAlive
}

func (this *Cell) SetNextGeneration() {
	if(this.countNeighbours < 2) || (this.countNeighbours > 3){
		this.isAlive = false
	}

}
