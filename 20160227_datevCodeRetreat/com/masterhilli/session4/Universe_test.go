package main

import (
	. "gopkg.in/check.v1"
	"testing"
)

type UniverseTestEngine struct {
}

func TestUniverseInitialize(t *testing.T) {
	Suite(&UniverseTestEngine{})
	TestingT(t)
}

func (this *UniverseTestEngine) TestNewUniverse_WithDimension3x4_ReturnsColumn3(c *C) {
	actualUniverse := NewUniverse(3,4)

	actualColumns, _ := actualUniverse.GetDimension()

	c.Assert(actualColumns, Equals, 3)
}

func (this *UniverseTestEngine) TestNewUniverse_WithDimension3x4_ReturnsRow4(c *C) {
	actualUniverse := NewUniverse(3,4)

	_, actualRows := actualUniverse.GetDimension()

	c.Assert(actualRows, Equals, 4)
}