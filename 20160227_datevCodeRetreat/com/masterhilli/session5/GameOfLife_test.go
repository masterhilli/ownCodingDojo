package GameOfLife

import (
	. "gopkg.in/check.v1"
	"testing"
)

type CellTestEngine struct {
	actualCell Cell
}

func TestInitialize(t *testing.T) {
	Suite(&CellTestEngine{})
	TestingT(t)
}

func (this *CellTestEngine) GivenAnAliveCell() *CellTestEngine {
	this.actualCell = Cell{}
	this.actualCell.isAlive = true
	return this
}

func (this *CellTestEngine) WithDeadCell() *CellTestEngine {
	this.actualCell.isAlive = false
	return this
}

func (this *CellTestEngine) WithUnderPopulatingNeighbours() *CellTestEngine {
	this.actualCell.countNeighbours = 1
	return this
}

func (this *CellTestEngine) WhenSetNextGeneration() {
	this.actualCell.SetNextGeneration()
}

func (this *CellTestEngine) ThenTheCellIsDead(c *C) {
	c.Assert(this.actualCell.isAlive, Equals, false)
}

func (this *CellTestEngine) TestSetIsAlive_WithTrue_ResultsIsAliveIsTrue(c *C) {
	actualCell := Cell{isAlive: false}

	actualCell.SetIsAlive(true)

	c.Assert(actualCell.isAlive, Equals, true)
}

func (this *CellTestEngine) TestSetNextGeneration_WithActiveCellAndOneNeighbour_ResultsCellDies(c *C) {
	this.GivenAnAliveCell().WithUnderPopulatingNeighbours()

	this.WhenSetNextGeneration()

	this.ThenTheCellIsDead(c)
}

func (this *CellTestEngine) TestSetNextGeneration_WithActiveCellAnd2Neighbour_ResultsCellIsAlive(c *C) {
	actualCell := Cell{isAlive: true, countNeighbours: 2}

	actualCell.SetNextGeneration()

	c.Assert(actualCell.isAlive, Equals, true)
}

func (this *CellTestEngine) TestSetNextGeneration_WithDeadCellAnd2Neighbour_ResultsCellIsDead(c *C) {
	actualCell := Cell{isAlive: false, countNeighbours: 2}

	actualCell.SetNextGeneration()

	c.Assert(actualCell.isAlive, Equals, false)
}

func (this *CellTestEngine) TestSetNextGeneration_WithAliveCellAnd4Neighbours_ResultsCellIsDead(c *C) {
	actualCell := Cell{isAlive: true, countNeighbours: 4}

	actualCell.SetNextGeneration()

	c.Assert(actualCell.isAlive, Equals, false)
}