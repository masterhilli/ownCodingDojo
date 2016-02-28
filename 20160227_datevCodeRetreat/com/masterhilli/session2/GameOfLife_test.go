package main

import (
	. "gopkg.in/check.v1"
	"testing"
)

type CellTestEngine struct {
}

func TestInitialize(t *testing.T) {
	Suite(&CellTestEngine{})
	TestingT(t)
}

func (this *CellTestEngine) TestNextGenerationWithCellAliveNeighboursCount4ReturnsDeadCell(c *C) {
	var actualCell Cell = Cell{alive: true, neighboursCount: 4}

	actualCell.NextGeneration()

	c.Assert(actualCell.alive, Equals, false)
}

func (this *CellTestEngine) TestNextGenerationWithCellAliveNeighboursCount1ReturnsDeadCell(c *C) {
	var actualCell Cell = Cell{alive: true, neighboursCount: 1}

	actualCell.NextGeneration()

	c.Assert(actualCell.alive, Equals, false)
}

func (this *CellTestEngine) TestNextGenerationWithCellAliveNeighboursCount2ReturnsAliveCell(c *C) {
	var actualCell Cell = Cell{alive: true, neighboursCount: 2}

	actualCell.NextGeneration()

	c.Assert(actualCell.alive, Equals, true)
}

func (this *CellTestEngine) TestNextGenerationWithCellDeadNeighboursCount2ReturnsDeadCell(c *C) {
	var actualCell Cell = Cell{alive: false, neighboursCount: 2}

	actualCell.NextGeneration()

	c.Assert(actualCell.alive, Equals, false)
}

func (this *CellTestEngine) TestNextGenerationWithCellAliveNeighboursCount3ReturnsAliveCell(c *C) {
	var actualCell Cell = Cell{alive: true, neighboursCount: 3}

	actualCell.NextGeneration()

	c.Assert(actualCell.alive, Equals, true)
}

func (this *CellTestEngine) TestNextGenerationWithCellDeadNeighboursCount3ReturnsAliveCell(c *C) {
	var actualCell Cell = Cell{alive: false, neighboursCount: 3}

	actualCell.NextGeneration()

	c.Assert(actualCell.alive, Equals, true)
}