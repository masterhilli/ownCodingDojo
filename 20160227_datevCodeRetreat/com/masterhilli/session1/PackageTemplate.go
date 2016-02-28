package main

func main() {
}

type GameOfLife struct {

}

func (this GameOfLife) Populate(amIaLive bool, neighbourCount int) bool {
	if 1 == neighbourCount {
		return false
	} else if (neighbourCount == 2) && amIaLive {
		return true
	} else if (neighbourCount == 3) {
		return true
	}
	return false
}
