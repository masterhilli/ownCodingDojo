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

func (this *CellTestEngine) TestNextGeneration_WithAliveCellAndNeighbourCount1_ReturnsDeadCell(c *C) {
	actualCell := Cell{ status: true, nc:1}

	actualCell.NextGeneration()

	c.Assert(actualCell.status, Equals, false)
}

func (this *CellTestEngine) TestNextGeneration_WithAliveCellAndNeighbourCount2_ReturnsAliveCell(c *C) {
	actualCell := Cell{ status: true, nc:2}

	actualCell.NextGeneration()

	c.Assert(actualCell.status, Equals, true)
}

func (this *CellTestEngine) TestNextGeneration_WithDeadCellAndNeighbourCount2_ReturnsDeadCell(c *C) {
	actualCell := Cell{ status: false, nc:2}

	actualCell.NextGeneration()

	c.Assert(actualCell.status, Equals, false)
}

func (this *CellTestEngine) TestNextGeneration_WithAliveCellAndNeighbourCount3_ReturnsAliveCell(c *C) {
	actualCell := Cell{ status: true, nc:3}

	actualCell.NextGeneration()

	c.Assert(actualCell.status, Equals, true)
}


func (this *CellTestEngine) TestNextGeneration_WithDeadCellAndNeighbourCount3_ReturnsAliveCell(c *C) {
	actualCell := Cell{ status: false, nc:3}

	actualCell.NextGeneration()

	c.Assert(actualCell.status, Equals, true)
}