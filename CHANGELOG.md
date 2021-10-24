# [1.0.0-alpha.6](https://github.com/giulioscattolin/plutonium/compare/v1.0.0-alpha.5...v1.0.0-alpha.6) (2021-10-24)


### Features

* add minus(), multiplyBy() and divideBy() to RectangularCoordinates ([1654a66](https://github.com/giulioscattolin/plutonium/commit/1654a663f6ed5cbdc6941862226e1ec3ec84ff9a))

# [1.0.0-alpha.5](https://github.com/giulioscattolin/plutonium/compare/v1.0.0-alpha.4...v1.0.0-alpha.5) (2021-10-24)


### Features

* add ECEFCoordinates ([00dcfc9](https://github.com/giulioscattolin/plutonium/commit/00dcfc99afae0e64a610e7acddeed8729b41bdb7))
* add RectangularCoordinates ([56859d5](https://github.com/giulioscattolin/plutonium/commit/56859d5e5831ea904629ef110ed7a2a1b1c3c134))

# [1.0.0-alpha.4](https://github.com/giulioscattolin/plutonium/compare/v1.0.0-alpha.3...v1.0.0-alpha.4) (2021-10-23)


### chore

* change library name to "plutonium" ([0ea5353](https://github.com/giulioscattolin/plutonium/commit/0ea53538ef5a496d18be65a2f4d2010c558b848b))


### BREAKING CHANGES

* dump "temporal-offset" as name of library

# [1.0.0-alpha.3](https://github.com/giulioscattolin/plutonium/compare/v1.0.0-alpha.2...v1.0.0-alpha.3) (2021-10-23)


### Features

* add EpochAndTemporalOffset ([e274099](https://github.com/giulioscattolin/plutonium/commit/e2740998e4238d618ee2dc2e13c8d0fc40c01edc))
* add TemporalCoordinate interface ([54ca4fd](https://github.com/giulioscattolin/plutonium/commit/54ca4fdb154e0c583523ba07609d29e51a63c8ab))

# [1.0.0-alpha.2](https://github.com/giulioscattolin/plutonium/compare/v1.0.0-alpha.1...v1.0.0-alpha.2) (2021-10-21)


### Features

* add BigDecimal implementation ([08e195b](https://github.com/giulioscattolin/plutonium/commit/08e195bd338267e6dcf034b13206e44e875a4610))
* add TemporalOffset and TemporalOffsetFactory interfaces ([980e926](https://github.com/giulioscattolin/plutonium/commit/980e926889345d8a910544ce1db19ffda8f6207e))
* rename makeNullOffset() to zero() ([dd80d93](https://github.com/giulioscattolin/plutonium/commit/dd80d9348f036e23131ecea2f195127da866b8de))


### Reverts

* remove TemporalOffset#isEqualTo() ([5013053](https://github.com/giulioscattolin/plutonium/commit/50130531570ed16df408b9d2f16cd6ec20f084c9))


### BREAKING CHANGES

* remove makeNullOffset()
* same semantics as equals()

# 1.0.0-alpha.1 (2021-10-21)


### Bug Fixes

* **build:** add missing "README.md" file ([463afcb](https://github.com/giulioscattolin/plutonium/commit/463afcb7b7309a7cca940172db86379d00943351))
* **build:** add missing "release" job ([2970837](https://github.com/giulioscattolin/plutonium/commit/29708378582a981abd3a9620923a3aa0e9816acd))


### Features

* **build:** implement Continuous Delivery ([3e38cc5](https://github.com/giulioscattolin/plutonium/commit/3e38cc5a0dd49fe46242eb844f51d8047e21fb11))
