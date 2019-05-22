[![Build Status][ci-img]][ci]
[![Coverage Status][coveralls-img]][coveralls]
# MockLambda
Similar to other mocking frameworks, **MockLambda** simulates an [AWS Lambda][aws-lambda] execution environment for unit testing.

This was achieved by implementing all the available and required Lambda Runtime interfaces, 
but also by supporting [dependency injection][di] through environment variables or values default to [AWS][aws].

In summary, this project enables local [TDD][tdd] practices while developing AWS Lambda functions.

  [ci-img]: https://api.travis-ci.com/connorvanelswyk/MockLambda.svg?branch=master
  [ci]: https://travis-ci.com/connorvanelswyk/MockLambda
  [coveralls-img]: https://coveralls.io/repos/github/connorvanelswyk/MockLambda/badge.svg?branch=master
  [coveralls]: https://coveralls.io/github/connorvanelswyk/MockLambda?branch=master
  [aws-lambda]: https://aws.amazon.com/lambda/
  [aws]: https://aws.amazon.com/
  [di]: https://en.wikipedia.org/wiki/Dependency_injection
  [tdd]: https://en.wikipedia.org/wiki/Test-driven_development