package main

type Cell struct {
	alive           bool
	neighboursCount int
}

func (this *Cell) NextGeneration() {
	if (this.neighboursCount == 3) {
		this.alive = true
	} else if (this.neighboursCount != 2) {
		this.alive = false
	}
}