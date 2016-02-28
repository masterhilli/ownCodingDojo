package main

type Cell struct {
	isAlive bool
}

func (this Cell) IsAlive () bool {
	return this.isAlive
}

func (this *Cell) SetIsAlive(isAlive bool) {
	this.isAlive = isAlive
}

type Universe struct {
	matrix [][]Cell
}

func (this *Universe) initMatrix (columnLen, rowLen int) {
	this.matrix = make([][]Cell, columnLen)

	for i := range this.matrix {
		this.matrix[i] = make([]Cell, rowLen)
	}
}

func (this Universe) GetDimension() (int, int) {
	if (this.matrix != nil) {
		return len(this.matrix), len(this.matrix[0])
	}
	return 0,0
}

func (this *Universe) SetCellAliveAt(column, row int) {
	if (this.matrix == nil) {
		return
	}

	if(len(this.matrix) <= column){
		return
	}

	if(len(this.matrix[0]) <= row){
		return
	}

	this.matrix[column][row] = Cell{isAlive: true}
}

func NewUniverse(columnLen, rowLen int) *Universe {
	newUniverse := &Universe{}
	newUniverse.initMatrix(columnLen, rowLen)
	return newUniverse
}