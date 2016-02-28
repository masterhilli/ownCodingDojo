package main

import (
	. "gopkg.in/check.v1"
	"testing"
)

type GameOfLifeTestEngine struct {
	GameOfLife
}

func TestInitialize(t *testing.T) {
	Suite(&GameOfLifeTestEngine{})
	TestingT(t)
}

func (this *GameOfLifeTestEngine) TestPopulateWithAliveCellAndOneNeighbourReturnsFalse(c *C) {
	actual := this.Populate(true, 1)
	c.Assert(actual, Equals, false)
}

func (this *GameOfLifeTestEngine) TestPopulateWithAliveCellAndTwoNeighbourReturnsTrue(c *C) {
	actual := this.GameOfLife.Populate(true, 2)
	c.Assert(actual, Equals, true)
}

func (this *GameOfLifeTestEngine) TestPopulateWithAliveCellAndFourNeighbourReturnsFalse(c *C) {
	actual := this.GameOfLife.Populate(true, 4)
	c.Assert(actual, Equals, false)
}

func (this *GameOfLifeTestEngine) TestPopulateWithDeadCellAndThreeNeighbourReturnsTrue(c *C) {
	actual := this.GameOfLife.Populate(false, 3)
	c.Assert(actual, Equals, true)
}

func (this *GameOfLifeTestEngine) TestPopulateWithDeadCellAndTwoNeighbourReturnsFalse(c *C) {
	actual := this.GameOfLife.Populate(false, 2)
	c.Assert(actual, Equals, false)
}
