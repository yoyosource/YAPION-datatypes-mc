[![YAPION Version V0.23.1](https://img.shields.io/badge/YAPION%20Version-0.23.1-red)](https://github.com/yoyosource/YAPION/tree/master/)
[![Java Version V1.8.0](https://img.shields.io/badge/Java%20Version-1.8.0-blue.svg)](https://github.com/yoyosource/YAPION/tree/master/)
[![License: Apache 2.0](https://img.shields.io/badge/license-Apache%202-blue)](http://www.apache.org/licenses/LICENSE-2.0)

# YAPION
**YAPION** is a slim and fast Object Notation specifically for Java Objects.
It can handle recursive Object structures and state specific serialization and deserialization (SsS/D).
This SsS/D is achieved by a self build annotation system used by YAPION. This object notation is designed for easy usage with complex Object structures and can do even more complex stuff fairly easy.   

## YAPION's naming
```
Y   -> @yoyosource   
API -> application programming interface
ON  -> object notation
```

## License
YAPION is licensed under the terms of the Apache License 2.0. See the file LICENSE or visit http://www.apache.org/licenses/LICENSE-2.0 for details.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

## Using in other Projects
YAPION is not published on jcenter or mavenCentral. It is published directly to this GitHub repository. You can declare it as a dependency in your gradle.build with:
```groovy
repositories {
    maven {
        url = uri("https://raw.githubusercontent.com/yoyosource/YAPION/master/releases")
    }
}

dependencies {
    implementation 'yoyosource:YAPION:0.23.1'
}
```

# APIs used
- yoyosource/YAPION (https://github.com/yoyosource/YAPION)
  - [V] 0.23.2
  - [L] Apache-2.0
- 

* [V] Version
* [L] License