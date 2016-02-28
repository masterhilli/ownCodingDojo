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

func (this *CellTestEngine) TestIsAlive_WithAliveCell_ReturnsTrue(c *C) {
	actualCell := Cell{isAlive: true}

	actual := actualCell.IsAlive()

	c.Assert(actual, Equals, true)
}

