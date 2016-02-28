package main

import (
	. "gopkg.in/check.v1"
	"testing"
)

type PackageTemplateTestEngine struct {
	MyMethodOutCome string
}

func TestInitialize(t *testing.T) {
	Suite(&PackageTemplateTestEngine{MyMethodOutCome: "Test"})
	TestingT(t)
}

func (this *PackageTemplateTestEngine) TestMyMethodReturnsTEST(c *C) {
	actual := MyMethod()
	c.Assert(actual, Equals, this.MyMethodOutCome)
}
