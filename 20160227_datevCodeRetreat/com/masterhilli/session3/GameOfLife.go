package main

type Cell struct {
	status bool
	nc int
}

func (this *Cell) NextGeneration() {
	if this.nc == 3 {
		this.status = true
	} else if this.nc != 2 {
		this.status = false
	}
}