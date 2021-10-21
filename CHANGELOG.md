# [1.0.0-alpha.2](https://github.com/giulioscattolin/temporal-offset/compare/v1.0.0-alpha.1...v1.0.0-alpha.2) (2021-10-21)


### Features

* add BigDecimal implementation ([08e195b](https://github.com/giulioscattolin/temporal-offset/commit/08e195bd338267e6dcf034b13206e44e875a4610))
* add TemporalOffset and TemporalOffsetFactory interfaces ([980e926](https://github.com/giulioscattolin/temporal-offset/commit/980e926889345d8a910544ce1db19ffda8f6207e))
* rename makeNullOffset() to zero() ([dd80d93](https://github.com/giulioscattolin/temporal-offset/commit/dd80d9348f036e23131ecea2f195127da866b8de))


### Reverts

* remove TemporalOffset#isEqualTo() ([5013053](https://github.com/giulioscattolin/temporal-offset/commit/50130531570ed16df408b9d2f16cd6ec20f084c9))


### BREAKING CHANGES

* remove makeNullOffset()
* same semantics as equals()

# 1.0.0-alpha.1 (2021-10-21)


### Bug Fixes

* **build:** add missing "README.md" file ([463afcb](https://github.com/giulioscattolin/temporal-offset/commit/463afcb7b7309a7cca940172db86379d00943351))
* **build:** add missing "release" job ([2970837](https://github.com/giulioscattolin/temporal-offset/commit/29708378582a981abd3a9620923a3aa0e9816acd))


### Features

* **build:** implement Continuous Delivery ([3e38cc5](https://github.com/giulioscattolin/temporal-offset/commit/3e38cc5a0dd49fe46242eb844f51d8047e21fb11))
